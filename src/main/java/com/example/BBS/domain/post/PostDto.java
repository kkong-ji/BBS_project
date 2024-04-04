package com.example.BBS.domain.post;
import com.example.BBS.domain.user.UserDto;
import lombok.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long postId;                  // 게시물 아이디
    private String postTitle;             // 게시물 제목
    private String postContent;           // 게시물 내용
    private LocalDateTime createAt;       // 게시물 작성 날짜
    private LocalDateTime updatedAt;      // 게시물 수정 날짜
    private LocalDateTime deletedAt;      // 게시물 삭제 날짜
    private Integer postRead;             // 게시물 조회수
    private Integer user_id;              // 게시물 작성자 아이디
    private String userName;              // 게시물 작성한 유저 이름

//  private Reply replyId;              // 댓글 아이디

    // 게시물 조회 생성자
    public PostDto(String postTitle, String postContent, String userName, Integer postRead) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userName = userName;
        this.postRead = postRead;
    }

    // 게시물 등록 생성자
    public PostDto(String postTitle, String postContent, String userName) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userName = userName;
    }
}
