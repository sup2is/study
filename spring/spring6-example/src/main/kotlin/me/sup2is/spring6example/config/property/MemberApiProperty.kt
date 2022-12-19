package me.sup2is.spring6example.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "api.member")
class MemberApiProperty(
    val url: String
)