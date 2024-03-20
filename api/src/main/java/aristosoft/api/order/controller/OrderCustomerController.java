package aristosoft.api.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aristosoft.api.order.service.OrderService;
import aristosoft.api.response.Respuesta;
import aristosoft.api.response.RespuestaType;

@RestController
@RequestMapping("/api/v1/order")
public class OrderCustomerController {

    @Autowired
    private OrderService service;

    @PostMapping("/create/{idCustomer}")
    public ResponseEntity<Respuesta> createOrder(@PathVariable("idCustomer") String idCustomer) {

        Respuesta response = service.createOrder(Integer.parseInt(idCustomer));

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

    @PostMapping("/addProduct")
    public ResponseEntity<Respuesta> addProduct(
            @RequestParam("orderCode") String orderCode,
            @RequestParam("idProduct") String idProduct,
            @RequestParam("quantity") String quantity) {

        Respuesta response = service.addProduct(orderCode, Integer.parseInt(idProduct), Integer.parseInt(quantity));

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

    @PostMapping("/deleteProduct")
    public ResponseEntity<Respuesta> deleteProduct(
            @RequestParam("orderCode") String orderCode,
            @RequestParam("idProduct") String idProduct) {

        Respuesta response = service.deleteProduct(orderCode, Integer.parseInt(idProduct));

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

    @GetMapping("/getOrder/{idCustomer}/{orderCode}")
    public ResponseEntity<Respuesta> getOrderDetails(
            @PathVariable("orderCode") String orderCode,
            @PathVariable("idCustomer") String idCustomer) {

        Respuesta response = service.getOrderByCode(orderCode, Integer.parseInt(idCustomer));

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

    @GetMapping("/updateOrder/{orderCode}")
    public ResponseEntity<Respuesta> updateOrder(
            @PathVariable("orderCode") String orderCode,
            @RequestParam("idCustomer") String idCustomer,
            @RequestParam("orderStatus") String orderStatus) {

        // Aqui se debe actualizar el stock de acuerdo a los datos
        return null;
    }

}
