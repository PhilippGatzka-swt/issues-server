package ch.sowatec.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
/**
 * @author gatzka
 * @version 1.0.0-Snapshot
 * Project: Issues
 */
@SuppressWarnings("unused")
@Table(name = "issue")
@Entity
@NamedQuery(name="Issue.findAll", query = "SELECT i FROM Issue i")
public class Issue extends AbstractEntity {
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "issue_id")
    private List<Vote> votes;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "solving_answer")
    private Answer answer;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "issue_id")
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}