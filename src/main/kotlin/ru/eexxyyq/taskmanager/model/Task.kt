package ru.eexxyyq.taskmanager.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    var user: User,
    var description: String,
    var status: TaskStatus = TaskStatus.NEW
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Task

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
