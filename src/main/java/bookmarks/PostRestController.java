package bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class PostRestController {

    private final PostRepository postRepository;

    @Autowired
    PostRestController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Post> findAll() {
        return this.postRepository.findAll();
    }
}
