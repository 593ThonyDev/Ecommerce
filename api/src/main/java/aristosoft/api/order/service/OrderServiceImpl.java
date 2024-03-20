package aristosoft.api.order.service;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import aristosoft.api.customer.service.CustomerService;
import aristosoft.api.order.repository.OrderRepository;
import aristosoft.api.orderDetail.model.OrderDetail;
import aristosoft.api.orderDetail.repository.OrderDetailRepository;
import aristosoft.api.product.model.Product;
import aristosoft.api.product.service.ProductService;
import aristosoft.api.status.OrderStatus;
import aristosoft.api.customer.model.*;
import aristosoft.api.order.model.*;
import aristosoft.api.response.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository repository;

    @Autowired
    private final OrderDetailRepository detailRepository;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final ProductService productService;

    @Override
    public Page<Order> getAll(Pageable pageable) {
        Page<Order> pagina = repository.findAll(pageable);
        if (pagina.isEmpty()) {
            return null;
        }
        return pagina;
    }

    @Override
    public Respuesta getById(Integer idOrder) {
        Optional<Order> order = repository.findById(idOrder);
        if (!order.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Registro no encontrado")
                    .build();
        }
        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .content(order)
                .build();
    }

    @Override
    public Respuesta getByCode(String code) {
        Optional<Order> order = repository.findByCode(code);
        if (!order.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("El registro no existe")
                    .build();
        }
        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .content(order)
                .build();
    }

    @Override
    public Respuesta updateStatus(Integer idCustomer, String status) {
        Optional<Order> optional = repository.findById(idCustomer);
        if (optional.isPresent()) {
            Order order = optional.get();
            status = status.toUpperCase();

            switch (status) {
                case "CREATED":
                    order.setStatus(OrderStatus.CREATED);
                    repository.save(order);
                    return Respuesta.builder()
                            .message("Orden creada")
                            .type(RespuestaType.SUCCESS)
                            .build();

                case "PAID":
                    order.setStatus(OrderStatus.PAID);
                    repository.save(order);
                    return Respuesta.builder()
                            .message("Orden pagada")
                            .type(RespuestaType.SUCCESS)
                            .build();

                case "DISPATCHING":
                    order.setStatus(OrderStatus.DISPATCHING);
                    repository.save(order);
                    return Respuesta.builder()
                            .message("Su orden está siendo despachada")
                            .type(RespuestaType.SUCCESS)
                            .build();

                case "DELIVERED":
                    order.setStatus(OrderStatus.DELIVERED);
                    repository.save(order);
                    return Respuesta.builder()
                            .message("Su orden ha sido entregada con éxito!")
                            .type(RespuestaType.SUCCESS)
                            .build();

                case "PAYMENT_FAILTURE":
                    order.setStatus(OrderStatus.PAYMENT_FAILTURE);
                    repository.save(order);
                    return Respuesta.builder()
                            .message("Pago fallido")
                            .type(RespuestaType.SUCCESS)
                            .build();

                default:
                    return Respuesta.builder()
                            .type(RespuestaType.WARNING)
                            .message("Estado desconocido")
                            .build();
            }

        } else {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("El registro no existe")
                    .build();
        }
    }

    @Override
    public Respuesta deleteById(Integer idOrder) {
        Optional<Order> optional = repository.findById(idOrder);
        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No existe el registro")
                    .build();
        } else {
            try {
                repository.deleteById(idOrder);
                return Respuesta.builder()
                        .type(RespuestaType.SUCCESS)
                        .message("Registro eliminado con exito")
                        .build();

            } catch (Exception e) {
                return Respuesta.builder()
                        .type(RespuestaType.WARNING)
                        .message("No se pudo eliminar el registro")
                        .build();
            }
        }
    }

    @Override
    @Transactional
    public Respuesta createOrder(Integer idCustomer) {

        if (idCustomer <= 0) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener un cliente")
                    .build();
        }

        Respuesta customerResponse = customerService.getById(idCustomer);

        if (customerResponse.getType() == RespuestaType.SUCCESS) {
            @SuppressWarnings("unchecked")
            Optional<Customer> customerOptional = (Optional<Customer>) customerResponse.getContent();

            if (customerOptional.isPresent()) {
                Customer customer = customerOptional.get();

                Integer orderCount = repository.countByStatusAndCustomer(OrderStatus.CREATED,
                        CustomerDto.builder().idCustomer(customer.getIdCustomer()).build());

                if (orderCount > 1) {
                    repository.deleteByStatusAndCustomer(OrderStatus.CREATED,
                            CustomerDto.builder().idCustomer(customer.getIdCustomer()).build());
                }

                if (orderCount == 1) {
                    Optional<Order> existingOrder = repository.findByStatusAndCustomer(OrderStatus.CREATED,
                            CustomerDto.builder().idCustomer(customer.getIdCustomer()).build());
                    if (existingOrder.isPresent()) {
                        Order order = Order.builder()
                                .code(existingOrder.get().getCode()).build();
                        return Respuesta.builder()
                                .type(RespuestaType.SUCCESS)
                                .content(order)
                                .build();
                    } else {
                        return Respuesta.builder()
                                .message("No se encontró la orden existente para el cliente")
                                .type(RespuestaType.WARNING)
                                .build();
                    }
                } else {

                    Order order = Order.builder()
                            .customer(CustomerDto.builder().idCustomer(customer.getIdCustomer()).build())
                            .code(UUID.randomUUID().toString())
                            .ammount(0.0)
                            .address(customer.getAddress())
                            .email(customer.getEmail())
                            .status(OrderStatus.CREATED)
                            .date(ZonedDateTime.now(ZoneId.of("America/Guayaquil")))
                            .build();

                    order = repository.save(order);

                    Order orderResponse = Order.builder()
                            .code(order.getCode())
                            .build();

                    return Respuesta.builder()
                            .type(RespuestaType.SUCCESS)
                            .content(orderResponse)
                            .build();
                }

            } else {
                return Respuesta.builder()
                        .message("Cliente no registrado")
                        .type(RespuestaType.WARNING)
                        .build();
            }
        } else {
            return Respuesta.builder()
                    .message("Cliente no registrado")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

    @Override
    public Respuesta addProduct(String orderCode, Integer fkProduct, Integer quantity) {
        // buscar el orderCode

        Optional<Order> orderOptional = repository.findByCode(orderCode);
        Order order = orderOptional.get();

        if (order.getStatus() != OrderStatus.CREATED) {
            return Respuesta.builder()
                    .message("La orden de compra ya ha sido procesada")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (!orderOptional.isPresent()) {
            return Respuesta.builder()
                    .message("No existe la orden de compra!")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        // Verificar el producto
        Respuesta prodRespuesta = productService.getById(fkProduct);
        if (prodRespuesta.getType() == RespuestaType.SUCCESS) {

            @SuppressWarnings("unchecked")
            Optional<Product> product = (Optional<Product>) prodRespuesta.getContent();

            if (quantity > product.get().getStock()) {
                return Respuesta.builder()
                        .message("Cantidad solicitada no disponible")
                        .type(RespuestaType.WARNING)
                        .build();
            }

            Optional<OrderDetail> detailOptional = detailRepository.findByOrderAndProduct(order, product.get());

            if (detailOptional.isPresent()) {

                OrderDetail detail = OrderDetail.builder()
                        .idDetail(detailOptional.get().getIdDetail())
                        .order(order)
                        .product(product.get())
                        .price(product.get().getPrice())
                        .quantity(quantity)
                        .preference(product.get().getDescription())
                        .build();

                detailRepository.save(detail);

                // Actualizar el monto del total a pagar
                order.setAmmount(detailRepository.calculateOrderTotal(order.getIdOrder()));
                repository.save(order);

                return Respuesta.builder()
                        .message("Cantidad del producto actualizado")
                        .type(RespuestaType.SUCCESS)
                        .build();

            } else {

                OrderDetail detail = OrderDetail.builder()
                        .order(orderOptional.get())
                        .product(product.get())
                        .price(product.get().getPrice())
                        .quantity(quantity)
                        .preference(product.get().getDescription())
                        .build();
                detailRepository.save(detail);

                // Actualizar el monto del total a pagar
                order.setAmmount(detailRepository.calculateOrderTotal(order.getIdOrder()));
                repository.save(order);

                return Respuesta.builder()
                        .message("Producto agregado al carrito")
                        .type(RespuestaType.SUCCESS)
                        .build();

            }

        } else {
            return Respuesta.builder()
                    .message("No existe el producto solicitado")
                    .type(RespuestaType.WARNING)
                    .build();

        }
    }

    @Override
    public Respuesta deleteProduct(String orderCode, Integer fkProduct) {
        // buscar el orderCode

        Optional<Order> orderOptional = repository.findByCode(orderCode);
        Order order = orderOptional.get();

        if (order.getStatus() != OrderStatus.CREATED) {
            return Respuesta.builder()
                    .message("La orden de compra ya ha sido procesada")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (!orderOptional.isPresent()) {
            return Respuesta.builder()
                    .message("No existe la orden de compra!")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        // Verificar el producto
        Respuesta prodRespuesta = productService.getById(fkProduct);
        if (prodRespuesta.getType() == RespuestaType.SUCCESS) {

            @SuppressWarnings("unchecked")
            Optional<Product> product = (Optional<Product>) prodRespuesta.getContent();

            Optional<OrderDetail> detailOptional = detailRepository.findByOrderAndProduct(order, product.get());

            if (detailOptional.isPresent()) {

                // Eliminar el detalle del producto por fkProduct
                detailRepository.deleteById(detailOptional.get().getIdDetail());

                // Actualizar el monto del total a pagar
                order.setAmmount(detailRepository.calculateOrderTotal(order.getIdOrder()));
                repository.save(order);

                return Respuesta.builder()
                        .message("Producto eliminado del carrito")
                        .type(RespuestaType.SUCCESS)
                        .build();

            } else {

                return Respuesta.builder()
                        .message("No existe el producto en el carrito")
                        .type(RespuestaType.WARNING)
                        .build();

            }

        } else {
            return Respuesta.builder()
                    .message("No existe el producto solicitado")
                    .type(RespuestaType.WARNING)
                    .build();

        }
    }

    @Override
    public Respuesta getOrderByCode(String orderCode, Integer fkCustomer) {

        Optional<Order> orderOptional = repository.findByCode(orderCode);

        if (orderOptional.get().getStatus() != OrderStatus.CREATED) {
            return Respuesta.builder()
                    .message("La orden de compra ya ha sido procesada")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (!orderOptional.isPresent()) {
            return Respuesta.builder()
                    .message("No existe la orden de con ese codigo")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (orderOptional.get().getCustomer().getIdCustomer() != fkCustomer) {
            return Respuesta.builder()
                    .message("Orden de compra no disponible")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        // Detalles de la orden para retornar
        Order order = Order.builder()
                .ammount(orderOptional.get().getAmmount())
                .date(orderOptional.get().getDate())
                .build();

        List<OrderDetail> orderDetails = detailRepository
                .findByOrder(Order.builder().idOrder(orderOptional.get().getIdOrder()).build());

        return Respuesta.builder()
                .extracontent(order)
                .content(orderDetails)
                .type(RespuestaType.SUCCESS)
                .build();

    }

}
