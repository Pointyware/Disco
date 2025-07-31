# Module :website
This modules contains the code and resources for the generated static website at `https://disco.pointyware.org`.

To build the static site content and output to `./build/static-site`, you can use the gradle task with the given arguments `./gradlew :website:run --args='--out build/static-site'` or you can run the "build website" stored run configuration in the Run Configuration Dropdown.

The output, in `./build/static-site`, can then be hosted as a static website.

## Site DSL
We have extended and wrapped the KotlinX HTML DSL to build up a hierarchy of html pages and other
resources.
