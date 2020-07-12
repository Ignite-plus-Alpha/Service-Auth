package alpha.profile.repo;

import alpha.profile.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CassandraRepository<User,String> {

}