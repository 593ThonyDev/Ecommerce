package aristosoft.api.orderDetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aristosoft.api.orderDetail.model.OrderDetailDto;
import aristosoft.api.orderDetail.model.OrderDetailRequest;
import aristosoft.api.orderDetail.service.OrderDetailService;
import aristosoft.api.response.Respuesta;
import aristosoft.api.response.RespuestaType;

@RestController
@RequestMapping("/api/v1/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService service;

    @GetMapping("/list/{fkOrder}")
    public ResponseEntity<List<OrderDetailDto>> getAll(@PathVariable("fkOrder") String fkOrder) {
        List<OrderDetailDto> list = service.getByFkOrder(Integer.parseInt(fkOrder));
        if (list != null && !list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Respuesta> save(
            @RequestParam("idOrden") String fkOrder,
            @RequestParam("idProducto") String fkProduct,
            @RequestParam("cantidad") String quantity) {

        OrderDetailRequest request = OrderDetailRequest.builder()
                .fkOrder(Integer.parseInt(fkOrder))
                .fkProduct(Integer.parseInt(fkProduct))
                .quantity(Integer.parseInt(quantity))
                .build();

        Respuesta response = service.save(request);

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

    @PatchMapping("/update")
    public ResponseEntity<Respuesta> update(
            @RequestParam("idDetail") String idDetail,
            @RequestParam("idOrden") String fkOrder,
            @RequestParam("idProducto") String fkProduct,
            @RequestParam("cantidad") String quantity) {

        OrderDetailRequest request = OrderDetailRequest.builder()
                .idDetail(Integer.parseInt(idDetail))
                .fkOrder(Integer.parseInt(fkOrder))
                .fkProduct(Integer.parseInt(fkProduct))
                .quantity(Integer.parseInt(quantity))
                .build();

        Respuesta response = service.update(request);

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

    @DeleteMapping("/{idDetail}")
    public ResponseEntity<Respuesta> delete(@PathVariable("idDetail") String idDetail) {

        Respuesta response = service.delete(Integer.parseInt(idDetail));

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
