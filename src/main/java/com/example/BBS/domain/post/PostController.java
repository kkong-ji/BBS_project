package com.example.BBS.domain.post;

import com.example.BBS.domain.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/hello")
    public String Hello() {
        return "/board/hello";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("boards", postService.postList());
        return "/board/boards";
    }

    @GetMapping("/{postId}")
    public String post(@PathVariable long postId, Model model) {
        model.addAttribute("board", postService.findById(postId));

        return "/board/content";
    }

    @PostMapping("/main")
    public String addPostMain(@RequestParam String postTitle, @RequestParam String postContent,
                       @RequestParam String userName, RedirectAttributes redirectAttributes) {
        PostDto newPost = new PostDto(postTitle, postContent, userName);
        Long postId = postService.add(newPost);
        System.out.println("postId = " + postId);

        redirectAttributes.addAttribute("postId", postId);
        redirectAttributes.addAttribute("status", true);

        return "redirect:/boards/{postId}";
    }

    @GetMapping("/{postId}/edit")
    public String editForm(@PathVariable Long postId, Model model) {
        PostDto findPost = postService.findById(postId);
        model.addAttribute("board", findPost);

        return "board/editForm";
    }

    @PostMapping("/{postId}/edit")
    public String editForm(@PathVariable Long postId, @RequestParam String postTitle, @RequestParam String postContent) {
        PostDto findPost = postService.findById(postId);
        findPost.setPostTitle(postTitle);
        findPost.setPostContent(postContent);

        postService.update(findPost);
        return "redirect:/boards/{postId}";
    }

    @GetMapping("/{postId}/delete")
    public String deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return "redirect:/boards/main";
    }

}
