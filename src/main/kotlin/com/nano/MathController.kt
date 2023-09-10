@@ -1,7 +1,10 @@
package com.nano

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.constraints.NotNull
@ -9,13 +12,19 @@ import javax.validation.constraints.NotNull
@Controller("/calculator")
@Validated
class MathController {
    @Post("/add")
    fun add(@Body @NotNull numbers: Numbers): Int {
        return numbers.first + numbers.second

    @Get("/greeting")
    fun greeting(): HttpResponse<String> {
        return HttpResponse.ok("Hello World!")
    }

    @Post("/add", produces = [MediaType.APPLICATION_JSON])
    fun add(@Body @NotNull numbers: Numbers): HttpResponse<String> {
        return HttpResponse.ok("""{"result": ${numbers.first + numbers.second} }""")
    }

    @Post("/subtract")
    fun subtract(@Body @NotNull numbers: Numbers): Int {
        return numbers.first - numbers.second
    @Post("/subtract", produces = [MediaType.APPLICATION_JSON])
    fun subtract(@Body @NotNull numbers: Numbers): HttpResponse<String> {
        return HttpResponse.ok("""{"result": ${numbers.first - numbers.second} }""")
    }
}