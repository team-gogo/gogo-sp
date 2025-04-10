package gogo.gogosp.global.internal.student.api

import gogo.gogosp.global.internal.student.stub.StudentByIdStub
import gogo.gogosp.global.internal.student.stub.StudentByIdsStub

interface StudentApi {
    fun queryByUserId(userId: Long): StudentByIdStub
    fun queryStudentsByStudentIds(studentIds: List<Long>): StudentByIdsStub
}