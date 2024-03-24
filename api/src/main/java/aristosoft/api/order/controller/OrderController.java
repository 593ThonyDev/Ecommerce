package aristosoft.api.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import aristosoft.api.order.model.Order;
import aristosoft.api.order.service.OrderService;
import aristosoft.api.response.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/allList")
    public ResponseEntity<Page<Order>> getAll(Pageable pageable) {
        Page<Order> pagina = service.getAll(pageable);
        if (pagina != null && pagina.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (pagina != null) {
            return ResponseEntity.ok(pagina);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<Respuesta> getById(@PathVariable("idOrder") String idOrder) {
        Respuesta response = service.getById(Integer.parseInt(idOrder));

        if (response.getType() == RespuestaType.SUCCESS) {
            return ResponseEntity.ok(Respuesta.builder()
                    .content(response.getContent())
                    .build());
        } else {
            return ResponseEntity.badRequest()
                    .body(Respuesta.builder().type(response.getType())
                            .message(response.getMessage())
                            .build());
        }
    }

    @GetMapping("/check/{idCustomer}/{orderCode}")
    public ResponseEntity<Respuesta> checkOrderAll(
            @PathVariable("orderCode") String orderCode,
            @PathVariable("idCustomer") String idCustomer) {

        Respuesta response = service.getOrderByCodeAdmin(orderCode, Integer.parseInt(idCustomer));

        if (response.getType() == RespuestaType.SUCCESS) {
            return ResponseEntity.ok(Respuesta.builder()
                    .content(response.getContent())
                    .extracontent(response.getExtracontent())
                    .build());
        } else {
            return ResponseEntity.badRequest()
                    .body(Respuesta.builder().type(response.getType())
                            .message(response.getMessage())
                            .build());
        }
    }
    @PatchMapping("/updateStatus")
    public ResponseEntity<Respuesta> updateStatus(
            @RequestParam("idOrden") String idOrder,
            @RequestParam("estado") String status) {

        Respuesta response = service.updateStatus(Integer.parseInt(idOrder), status);

        if (response.getType() == RespuestaType.SUCCESS) {
            return ResponseEntity.ok(Respuesta.builder()
                    .message(response.getMessage())
                    .build());
        } else {
            return ResponseEntity.badRequest()
                    .body(Respuesta.builder().type(response.getType())
                            .message(response.getMessage())
                            .build());
        }
    }

    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<Order>> searchOrder(@PathVariable("searchTerm") String searchTerm) {
        List<Order> lista = service.getOrderByCodeAndCustomer(searchTerm);
        if (lista != null && lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (lista != null) {
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
