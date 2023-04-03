package com.ontop.walletservice.domain.service.recipient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.ontop.walletservice.domain.exception.AccountNotFoundException;
import com.ontop.walletservice.domain.exception.InvalidBankAccountException;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.repository.RecipientBankAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DomainRecipientBankAccountServiceTest {

    @InjectMocks
    private DomianRecipientBankAccountService service;

    @Mock
    private RecipientBankAccountRepository repository;

    private RecipientBankAccount sampleBankAccount;

    @BeforeEach
    public void setUp() {
        sampleBankAccount = new RecipientBankAccount(1L, "123456789", "987654321", "Bank Name",
                "First", "Last", 123456789L, 1L, "USD");
    }

    @Test
    public void testCreateBankAccount() {
        when(repository.findByUserId(sampleBankAccount.getUserId())).thenReturn(Optional.empty());
        when(repository.save(sampleBankAccount)).thenReturn(sampleBankAccount);

        RecipientBankAccount result = service.createBankAccount(sampleBankAccount);

        assertEquals(sampleBankAccount, result);
        verify(repository).findByUserId(sampleBankAccount.getUserId());
        verify(repository).save(sampleBankAccount);
    }

    @Test
    public void testCreateBankAccountWithNullData() {
        assertThrows(InvalidBankAccountException.class, () -> service.createBankAccount(null));
    }

    @Test
    public void testCreateBankAccountWithExistingUser() {
        when(repository.findByUserId(sampleBankAccount.getUserId())).thenReturn(Optional.of(sampleBankAccount));

        assertThrows(InvalidBankAccountException.class, () -> service.createBankAccount(sampleBankAccount));
        verify(repository).findByUserId(sampleBankAccount.getUserId());
    }

    @Test
    public void testGetBankAccountByUserId() {
        when(repository.findByUserId(sampleBankAccount.getUserId())).thenReturn(Optional.of(sampleBankAccount));

        RecipientBankAccount result = service.getBankAccountByUserId(sampleBankAccount.getUserId());

        assertEquals(sampleBankAccount, result);
        verify(repository).findByUserId(sampleBankAccount.getUserId());
    }

    @Test
    public void testGetBankAccountByUserIdNotFound() {
        when(repository.findByUserId(sampleBankAccount.getUserId())).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> service.getBankAccountByUserId(sampleBankAccount.getUserId()));
        verify(repository).findByUserId(sampleBankAccount.getUserId());
    }
}
