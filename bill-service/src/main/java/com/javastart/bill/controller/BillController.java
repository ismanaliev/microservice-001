package com.javastart.bill.controller;

import com.javastart.bill.dto.BillRequestDTO;
import com.javastart.bill.dto.BillResponseDTO;
import com.javastart.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

private final BillService billService;
    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

@GetMapping("/getBill/{billId}")
    public BillResponseDTO getBill(@PathVariable("billId") Long billId){
        return billService.billToResponse(billService.getBillById(billId));
}
@PostMapping("/createBill/")
    public Long createBill(@RequestBody BillRequestDTO bill){
        return billService.createBill(bill.getAccountId(),bill.getAmount(),bill.getIsDefault(),bill.getOverdraftEnabled());
}
@PutMapping("/updateBill/{billId}")
    public BillResponseDTO updateBill(@PathVariable("billId") Long billId,@RequestBody BillRequestDTO b){
                return billService.billToResponse(billService.updateBill(billId,b.getAccountId(),b.getAmount(),b.getOverdraftEnabled(),b.getIsDefault(),b.getCreationDate()));
}
@DeleteMapping("/deleteBill/{billId}")
    public BillResponseDTO deleteBill(@PathVariable("billId")Long billId){
    return billService.billToResponse(billService.deleteBill(billId));

}
}
