package com.ontop.walletservice.domain.repository;

import com.ontop.walletservice.domain.model.wallet.WalletBankAccount;

import java.util.Optional;

public interface WalletBankAccountRepository {

    Optional<WalletBankAccount> getCurrentWalletBankAccount();

}
