package org.terexteam.memo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.terexteam.memo.repository.MemoRepository

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [MemoRepository::class])
class MemoApplication

fun main(args: Array<String>) {
    runApplication<MemoApplication>(*args)
}
