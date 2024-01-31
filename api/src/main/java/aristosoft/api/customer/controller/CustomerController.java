package aristosoft.api.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.customer.model.Customer;
import aristosoft.api.customer.service.CustomerService;
import aristosoft.api.response.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> getAll(Pageable pageable) {
        Page<Customer> pagina = service.getAll(pageable);
        if (pagina != null && pagina.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (pagina != null) {
            return ResponseEntity.ok(pagina);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Respuesta> getById(@PathVariable("idCliente") String idCliente) {
        Respuesta response = service.getById(Integer.parseInt(idCliente));

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

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Respuesta> deleteById(@PathVariable("idCliente") String idCustomer) {

        Respuesta response = service.deleteById(Integer.parseInt(idCustomer));

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

    @PostMapping("/save")
    public ResponseEntity<Respuesta> save(
            @RequestParam("nombres") String fullName,
            @RequestParam("email") String email,
            @RequestParam("direccion") String address,
            @RequestParam("pais") String country,
            @RequestParam("codigoPostal") String zip,
            @RequestParam("telefono") String phone) {

        Customer customer = Customer.builder()
                .fullName(fullName)
                .email(email)
                .phone(phone)
                .address(address)
                .country(country)
                .zip(zip)
                .build();

        Respuesta response = service.save(customer);

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
            @RequestParam("idCliente") String idCustomer,
            @RequestParam("nombres") String fullName,
            @RequestParam("email") String email,
            @RequestParam("direccion") String address,
            @RequestParam("pais") String country,
            @RequestParam("codigoPostal") String zip,
            @RequestParam("telefono") String phone) {

        Customer customer = Customer.builder()
                .idCustomer(Integer.parseInt(idCustomer))
                .fullName(fullName)
                .email(email)
                .phone(phone)
                .address(address)
                .country(country)
                .zip(zip)
                .build();

        Respuesta response = service.update(customer);

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

    @PatchMapping("/updatePhoto")
    public ResponseEntity<Respuesta> updateFotoPerfil(
            @RequestParam("idCliente") String idCustomer,
            @RequestParam(name = "photo", required = false) MultipartFile photo) {

        Respuesta response = service.updatePhoto(Integer.parseInt(idCustomer), photo);

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
