plugins {
    id("dev.kikugie.stonecutter")
}

stonecutter active "yumi-26.1" /* [SC] DO NOT EDIT */

tasks.register("chiseledBuild") {
    group = "project"
    dependsOn(stonecutter.tasks.named("build"))
}

tasks.register("chiseledPublish") {
    group = "project"
    dependsOn(stonecutter.tasks.named("publish"))
}
