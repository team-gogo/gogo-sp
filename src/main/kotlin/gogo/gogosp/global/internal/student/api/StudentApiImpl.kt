package gogo.gogosp.global.internal.student.api

import gogo.gogosp.global.feign.client.StudentClient
import gogo.gogosp.global.internal.student.stub.StudentByIdStub
import gogo.gogosp.global.internal.student.stub.StudentByIdsStub
import org.springframework.stereotype.Component

@Component
class StudentApiImpl(
    private val studentClient: StudentClient
) : StudentApi {
    override fun queryByUserId(userId: Long): StudentByIdStub {
        return studentClient.queryStudentByUserId(userId)
    }

    override fun queryStudentsByStudentIds(studentIds: List<Long>): StudentByIdsStub {
        return studentClient.queryStudentsByStudentIds(studentIds)
    }
}
