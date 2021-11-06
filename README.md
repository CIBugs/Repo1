# CI-Bugs 

This is a collection of regression bugs from the real time build pipe line (Travis) from 40 diverse projects.

| Organization  | Project | Bugs |
| ------------- | ------------- |-------------  |
|alibaba|fastjson|7|
|apache|commons-lang|2|
|apache|pdfbox|2|
|apache|struts|1
|biojava|biojava|1|
|brettwooldridge|HikariCP|9|
|caelum|vraptor4|3|
|chewiebug|GCViewer|2|
|datacleaner|DataCleaner|8|
|davidmoten|rxjava-jdbc|2|
|fayder|restcountries|1|
|FluentLenium|FluentLenium|1|
|google|error-prone|1|
|ImmobilienScout24|deadcode4j|1|
|jamesagnew|hapi-fhir|4|
|keycloak|keycloak|1|
|mikera|vectorz|2|
|mybatis|mybatis-3|3|
|NitorCreations|nflow|2|
|nutzam|nutz|2|
|ontop|ontop|1|
|openmicroscopy|bioformats|1|
|openpnp|openpnp|2|
|orbit|orbit|2|
|owlcs|owlapi|7|
|petergeneric|stdlib|2|
|rackerlabs|blueflood|1|
|raphw|byte-buddy|7|
|redpen-cc|redpen|3|
|SpigotMC|BungeeCord|1|
|spring-projects|spring-data-jpa|1|
|square|okhttp|1|
|square|retrofit|1|
|swagger-api|swagger-core|1|
|tananaev|traccar|9|
|timmolter|XChange|2|
|vavr-io|vavr|3|
|xetorthio|jedis|1|
|yamcs|yamcs|1|


## Setup
Each bug is setup as a separate branch. Each branch as 3 commits, (i) Initial commit with read me file, ignore this, (ii) buggy commit and (iii) bug fixed commit. Each bug has link to the original github in comments for reference To setup a bug, clone the repo and checkout the required branch and only take the last 2 commits of the interested branch.

### Example to setup the Bug1

#### Checkout Bug1
- git checkout Bug1

#### Buggy Commit
- git reset --hard 4e628d461dbe05f6909bb1783d63f145b3f90db2

#### Fixed Commit
- git reset --hard 804fcb6a3d8b8425bcec1ad82d4dd8047bdb4cf3
