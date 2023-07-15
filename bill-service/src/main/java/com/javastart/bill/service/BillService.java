package com.javastart.bill.service;

import com.javastart.bill.dto.BillResponseDTO;
import com.javastart.bill.entity.Bill;
import com.javastart.bill.exception.BillNotFoundException;
import com.javastart.bill.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class BillService {
    private final BillRepository billRepository;

    public Bill getBillById(Long billId) {
        return billRepository.findById(billId).orElseThrow(() -> new BillNotFoundException("Unable bill with id" + billId));
    }

    public Long createBill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
        Bill bill = new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overdraftEnabled);
        return billRepository.save(bill).getBillId();
    }

    public Bill updateBill(Long billId, Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled, OffsetDateTime creationDate) {
        Bill bill = getBillById(billId);
        bill.setAccountId(accountId);
        bill.setAmount(amount);
        bill.setIsDefault(isDefault);
        bill.setOverdraftEnabled(overdraftEnabled);
        return billRepository.save(bill);
    }
    public BillResponseDTO billToResponse(Bill b){
        BillResponseDTO bill=new BillResponseDTO();
        bill.setAccountId(b.getAccountId());
        bill.setBillId(b.getBillId());
        bill.setOverdraftEnabled(b.getOverdraftEnabled());
        bill.setAmount(b.getAmount());
        bill.setIsDefault(b.getIsDefault());
        bill.setCreationDate(b.getCreationDate());
        return bill;
    }

    public Bill deleteBill(Long billId) {
        billRepository.deleteById(billId);
        return getBillById(billId);
    }
}
