package Interface;

import Dto.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserServiceInteface extends MongoRepository<User,String> {
    @NotNull
    List<User> findAll();

    User findUsersByReferral(String ref);
    @Nullable
    User findUserByUsername(String username);




    @Override
    <S extends User> S insert(S entity);

    @Override
    <S extends User> S save(S entity);

    @Override
    <S extends User> Optional<S> findOne(Example<S> example);

}
