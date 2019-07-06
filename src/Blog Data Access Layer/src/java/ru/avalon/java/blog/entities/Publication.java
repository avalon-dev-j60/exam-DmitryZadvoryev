
package ru.avalon.java.blog.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(name = "list-publications", query = "SELECT p FROM Publication AS p"),
    @NamedQuery(name = "find-publications-by-user", query = "SELECT p FROM Publication AS p WHERE p.author = :user"),
      @NamedQuery(name = "find-publication-by-id", query = "SELECT p FROM Publication AS p WHERE p.id = :id")
})
@Entity
public class Publication  implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "CLOB")
    private String content;
    
    @OneToOne()
    @JoinColumn(nullable = false)
    private User author;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    protected Publication(){}

    public Publication(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        created = new Date();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreated() {
        return created;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
