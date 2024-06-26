package br.com.tokiomarine.FinTransferApi.controllers;

import br.com.tokiomarine.FinTransferApi.entity.Transferencia;
import br.com.tokiomarine.FinTransferApi.models.request.TransfRequest;
import br.com.tokiomarine.FinTransferApi.models.response.ApiResponse;
import br.com.tokiomarine.FinTransferApi.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transferencia")
@CrossOrigin(origins = "*")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> saveTransferencia(@RequestBody TransfRequest transfRequest){
        try {
            transferenciaService.saveTransferencia(transfRequest);
            return ResponseEntity.ok().body(new ApiResponse(true, "Operacao realizada com sucesso"));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "ERRO: " + e.getMessage()));
        }
    }

    @GetMapping(path = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getTransferencias(){
        try {
            List<Transferencia> transferencias = transferenciaService.getAllTransferencias();
            return ResponseEntity.ok().body(transferencias);
        }catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "ERRO: " + e.getMessage()));
        }
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getTransferencias(@RequestParam Long id){
        try {
            Transferencia transferencia = transferenciaService.getTransferenciasById(id);
            return ResponseEntity.ok().body(transferencia);
        }catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "ERRO: " + e.getMessage()));
        }
    }
}
