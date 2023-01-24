package org.terexteam.memo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.terexteam.memo.model.Memo

/**
 * @author nterehin on 24.01.2023
 */
interface MemoRepository : JpaRepository<Memo, Long>