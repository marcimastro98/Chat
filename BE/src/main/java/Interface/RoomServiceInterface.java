package Interface;

import Dto.Room;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomServiceInterface extends MongoRepository<Room, String> {
    @Override
    <S extends Room> S insert(S entity);


    Room findRoomBy_idAndReferal(Object id,String referal);


    List<Room> findAllByRoomPremiumAndRoomLanguage(boolean isPremium,String language);

    List<Room> findAllByReferal(String referal);

    @Override
    <S extends Room> S save(S entity);

    Room deleteAllBy_id(ObjectId id);
}
