//package com.example.getmap.Repository;
//
//import com.example.getmap.model.Message;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository("fakeDao")
//public class FakeMessageDataAccessService implements MessageDao {
//
//    private static List<Message> DB = new ArrayList<>();
//
//    @Override
//    public List<Message> selectAllMessages() {
//        return DB;
//    }
//
//    @Override
//    public int insertMessage(UUID id, Message message) {
//        DB.add(new Message(id, message.getMessage()));
//        return 1;
//    }
//
//    @Override
//    public Optional<Message> selectMessageById(UUID id) {
//        return DB.stream()
//                .filter(message -> message.getId().equals(id))
//                .findFirst();
//    }
//
//    @Override
//    public int deleteMessageByID(UUID id) {
//        Optional<Message> messageMaybe = selectMessageById(id);
//        if(messageMaybe.isEmpty()) {
//            return 0;
//        }
//        DB.remove(messageMaybe.get());
//        return 1;
//    }
//
//    @Override
//    public int updateMessageById(UUID id, Message update) {
//        return selectMessageById(id)
//                .map(message -> {
//                    int indexOfMessageToUpdate = DB.indexOf(message);
//                    if(indexOfMessageToUpdate >= 0){
//                        DB.set(indexOfMessageToUpdate, new Message(id, update.getMessage()));
//                        return 1;
//                    }
//                    return 0;
//                })
//                .orElse(0);
//    }
//}
