package ch.sowatec.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "vote")
@Entity
@NamedQuery(name="Vote.findAll", query = "SELECT v FROM Vote v")
public class Vote extends AbstractEntity {
    @Column(name = "is_upvote", nullable = false)
    private boolean isUpvote;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getIsUpvote() {
        return isUpvote;
    }

    public void setIsUpvote(boolean isUpvote) {
        this.isUpvote = isUpvote;
    }
}