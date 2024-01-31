package aristosoft.api.orderDetail.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aristosoft.api.order.model.Order;
import aristosoft.api.order.repository.OrderRepository;
import aristosoft.api.orderDetail.model.*;
import aristosoft.api.orderDetail.repository.OrderDetailDtoRepository;
import aristosoft.api.orderDetail.repository.OrderDetailRepository;
import aristosoft.api.product.model.Product;
import aristosoft.api.product.repository.ProductRepository;
import aristosoft.api.response.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private final OrderDetailRepository repository;

    @Autowired
    private final OrderDetailDtoRepository dtoRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final OrderRepository orderRepository;


    @Override
    public List<OrderDetailDto> getByFkOrder(Integer fkOrder) {
        List<OrderDetailDto> orderDetails = dtoRepository.findByfkOrder(fkOrder);

        if (orderDetails.isEmpty()) {
            return null;
        }
        return orderDetails;
    }

    @Override
    public Respuesta save(OrderDetailRequest request) {

        if (request.getFkOrder() <= 0) {
            return Respuesta.builder()
                    .message("Debe tener un id de Orden")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getFkProduct() <= 0) {
            return Respuesta.builder()
                    .message("Debe tener un producto")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getQuantity() <= 0) {
            return Respuesta.builder()
                    .message("Ingrese una cantidad valida")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        Optional<Product> product = productRepository.findById(request.getFkProduct());
        Optional<Order> order = orderRepository.findById(request.getFkOrder());

        if (!product.isPresent()) {
            return Respuesta.builder()
                    .message("No existe el producto solicitado")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (!order.isPresent()) {
            return Respuesta.builder()
                    .message("No existe el registro de venta")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getQuantity() > product.get().getStock()) {
            return Respuesta.builder()
                    .message("La cantidad solicitada excede a nuestro stock disponible")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        // Actualizamos el stock
        product.get().setStock(product.get().getStock() - request.getQuantity());
        productRepository.save(product.get());

        OrderDetail detail = OrderDetail.builder()
                .fkOrder(order.get())
                .fkProduct(product.get())
                .preference(product.get().getDescription())
                .quantity(request.getQuantity())
                .price(request.getQuantity() * product.get().getPrice())
                .build();

        repository.save(detail);
        order.get().setAmmount(repository.getTotalAmountByFkOrder(request.getFkProduct()));
        orderRepository.save(order.get());

        return Respuesta.builder()
                .message("Producto agregado al carrito")
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta update(OrderDetailRequest request) {

        if (request.getIdDetail() <= 0) {
            return Respuesta.builder()
                    .message("Debe tener un id el Detalle")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getFkOrder() <= 0) {
            return Respuesta.builder()
                    .message("Debe tener un id de Orden")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getFkProduct() <= 0) {
            return Respuesta.builder()
                    .message("Debe tener un producto")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getQuantity() <= 0) {
            return Respuesta.builder()
                    .message("Ingrese una cantidad válida")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        Optional<Product> product = productRepository.findById(request.getFkProduct());
        Optional<Order> order = orderRepository.findById(request.getFkOrder());

        // Devuelve una respuesta de advertencia si no encuentra el producto o la orden.
        if (!product.isPresent()) {
            return Respuesta.builder()
                    .message("No existe el producto solicitado")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (!order.isPresent()) {
            return Respuesta.builder()
                    .message("No existe el registro de venta")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        Optional<OrderDetail> optional = repository.findById(request.getIdDetail());

        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .message("No existe el registro para ser modificado")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getQuantity() == optional.get().getQuantity()) {
            return Respuesta.builder()
                    .message("La cantidad solicitada es la misma")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        Integer cantBd = optional.get().getQuantity();
        Integer cantSolicitada = request.getQuantity();
        Integer cantidadStock = product.get().getStock();
        Integer cantTotal;

        if (cantBd < cantSolicitada) {
            product.get().setStock(cantidadStock - (cantSolicitada - cantBd));
        }

        if (cantBd > cantSolicitada) {
            cantTotal = cantBd - cantSolicitada;
            product.get().setStock(cantidadStock - cantTotal);
        }

        if (request.getQuantity() > product.get().getStock()) {
            return Respuesta.builder()
                    .message("La cantidad solicitada excede a nuestro stock disponible")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        product.get().setStock(product.get().getStock() - request.getQuantity());
        productRepository.save(product.get());

        OrderDetail detail = OrderDetail.builder()
                .idDetail(request.getIdDetail())
                .fkOrder(order.get())
                .fkProduct(product.get())
                .preference(product.get().getDescription())
                .quantity(request.getQuantity())
                .price(request.getQuantity() * product.get().getPrice())
                .build();

        repository.save(detail);

        order.get().setAmmount(repository.getTotalAmountByFkOrder(request.getFkProduct()));
        orderRepository.save(order.get());

        return Respuesta.builder()
                .message("Carrito de compras actualizado")
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta delete(Integer idOrderDetail) {
        Optional<OrderDetail> optional = repository.findById(idOrderDetail);

        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .message("No existe el item en la orden de compra")
                    .type(RespuestaType.SUCCESS)
                    .build();
        }

        Optional<Product> product = productRepository.findById(optional.get().getFkProduct().getIdProduct());
        if (!product.isPresent()) {
            return Respuesta.builder()
                    .message("Producto no registrado")
                    .type(RespuestaType.SUCCESS)
                    .build();
        }

        product.get().setStock(optional.get().getQuantity() + product.get().getStock());
        productRepository.save(product.get());
        repository.deleteById(idOrderDetail);

        Optional<Order> order = orderRepository.findById(optional.get().getFkOrder().getIdOrder());

        order.get().setAmmount(repository.getTotalAmountByFkOrder(product.get().getIdProduct()));
        orderRepository.save(order.get());

        return Respuesta.builder()
                .message("Carrito de compras actualizado")
                .type(RespuestaType.SUCCESS)
                .build();

    }

}
