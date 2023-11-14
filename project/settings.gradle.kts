rootProject.name = "build"
include("src:main:graph")
findProject(":src:main:graph")?.name = "graph"
