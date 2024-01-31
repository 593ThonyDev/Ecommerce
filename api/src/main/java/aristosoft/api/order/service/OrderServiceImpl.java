package aristosoft.api.order.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import aristosoft.api.customer.model.CustomerDto;
import aristosoft.api.order.model.*;
import aristosoft.api.order.repository.OrderRepository;
import aristosoft.api.response.*;
import aristosoft.api.status.OrderStatus;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository repository;

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
    public Respuesta save(OrderRequest request) {
        if (request.getFkCustomer() <= 0) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe estar ligado a un cliente")
                    .build();
        }

        if (request.getAddress().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("La direccion esta vacia")
                    .build();
        }

        Order order = Order.builder()
                .customer(CustomerDto.builder().idCustomer(request.getFkCustomer()).build())
                .code(UUID.randomUUID().toString())
                .ammount(0.0)
                .address(request.getAddress())
                .email(request.getEmail())
                .status(OrderStatus.CREATED)
                .date(request.getFecha())
                .build();

        repository.save(order);

        order.setDate(null);
        order.setAmmount(null);

        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .content(order)
                .build();
    }

    @Override
    public Respuesta update(OrderRequest request) {

        if (request.getIdOrder() <= 0) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe estar ligado a un cliente")
                    .build();
        }

        if (request.getFkCustomer() <= 0) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe estar ligado a un cliente")
                    .build();
        }

        if (request.getAmmount() < 0) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No se permiten perdidas en la compra")
                    .build();
        }

        if (request.getAddress().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("La direccion esta vacia")
                    .build();
        }

        Optional<Order> optional = repository.findById(request.getIdOrder());
        
        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("El registro no existe")
                    .build();
        }

        Order order = new Order();

        optional.get().setAmmount(request.getAmmount());
        optional.get().setAddress(request.getAddress());
        optional.get().setEmail(request.getEmail());
        optional.get().setDate(order.getFecha());
        
        repository.save(optional.get());

        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .content(optional.get())
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

}
