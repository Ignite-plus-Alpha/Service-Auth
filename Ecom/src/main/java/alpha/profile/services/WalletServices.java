package alpha.profile.services;

import alpha.profile.exceptions.WalletNotFoundException;
import alpha.profile.model.Wallet;
import alpha.profile.repo.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class WalletServices {
    @Autowired
    private WalletRepo walletRepo;


    public Wallet createWallet(Wallet wallet) {
        return walletRepo.save(wallet);
    }


    public List<Wallet> getAllWallet() {
        return walletRepo.findAll();
    }

    public Optional<Wallet> getWalletById(String walletId) throws WalletNotFoundException {
        Optional<Wallet> wallet = walletRepo.findById(walletId);

        if (!wallet.isPresent())
            throw new WalletNotFoundException("Card not found");
        return wallet;
    }

    public void deleteWalletById(String walletId) {
        Optional<Wallet> wallet = walletRepo.findById(walletId);
        if (!wallet.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Card not found in repo,enter correct details");
        }
        walletRepo.deleteById(walletId);
    }

    public Wallet updateWalletById(String walletId, String Cardholder_name) throws WalletNotFoundException {
        Optional<Wallet> walletData = walletRepo.findById(walletId);

        if (walletRepo.findById(walletId).isPresent()) {
            Wallet wallet = walletData.get();
            wallet.setCardholderName(Cardholder_name);
            return walletRepo.save(wallet);
        }
        throw new WalletNotFoundException("Wallet not found");
    }
}
