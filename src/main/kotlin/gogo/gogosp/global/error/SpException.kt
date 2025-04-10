package gogo.gogosp.global.error

open class SpException(
    override val message: String,
    val status: Int
) : RuntimeException(message)
