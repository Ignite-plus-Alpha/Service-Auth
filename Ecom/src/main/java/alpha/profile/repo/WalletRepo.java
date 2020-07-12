package alpha.profile.repo;

import alpha.profile.model.Wallet;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends CassandraRepository<Wallet,String> {

}
