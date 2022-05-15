package com.restfulwebservices.user;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class UserRepository {


   private static final List<User> userList = new ArrayList<>();
   private static long userCount = 3L;

   static  {
       userList.add(new User(1L, "Steve", LocalDate.of(1997, 7, 27)));
       userList.add(new User(2L, "Mark", LocalDate.of(1996, 6, 26)));
       userList.add(new User(3L, "Frank", LocalDate.of(1995, 5, 25)));
   }

   public List<User> findAll() {
       return userList;
   }


   public User save(final User user) {
       if (user.getId() == null) {
           user.setId(++userCount);
       }
       userList.add(user);
       return  user;
   }

   public User findById(final Long id) {
       return userList.stream()
               .filter( user ->  user.getId().equals(id) )
               .findFirst().orElse(null);
   }


   public User deleteById(final Long id) {
       return findAndRemoveFirst(userList, user -> user.getId().equals(id));
   }


    public static <T> T findAndRemoveFirst(final Iterable<? extends T> collection, final Predicate<? super T> test) {
        T value = null;
        for (Iterator<? extends T> it = collection.iterator(); it.hasNext();)
            if (test.test(value = it.next())) {
                it.remove();
                return value;
            }
        return null;
    }


}
