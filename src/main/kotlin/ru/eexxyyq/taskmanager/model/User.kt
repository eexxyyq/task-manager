package ru.eexxyyq.taskmanager.model

import org.hibernate.Hibernate
import org.hibernate.annotations.Formula
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    var firstName: String,
    var lastName: String,
    var birth: Instant,
    @Formula("(select date_part('year', age(current_timestamp, birth)) from users u where u.id = id)")
    var age: Int?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
