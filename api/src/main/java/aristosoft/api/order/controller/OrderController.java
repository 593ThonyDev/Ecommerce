package aristosoft.api.order.controller;

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

    @GetMapping("/code/{code}")
    public ResponseEntity<Respuesta> getByCode(@PathVariable("code") String code) {
        Respuesta response = service.getByCode(code);
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

}
