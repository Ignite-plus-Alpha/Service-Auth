package alpha.profile.repo;

import alpha.profile.model.Address;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CassandraRepository<Address,String> {

}
