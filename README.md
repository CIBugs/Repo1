# CI-Bugs 

This is a collection of 102 regression bugs from the real time build pipe line (Travis) from 40 diverse projects.

## Setup
Each bug is setup as a separate branch and each branch as 3 commits.
- Initial commit (ignore this commit)
- Buggy commit 
- Fixed commit

To setup a bug, below are the steps
- Clone the repo 
- Chckout the required buggy branch 
- Take the last 2 commits (Buggy and Fixed Commit)
  - *Every commit has link to the original github in comments for reference. 

### Example to setup a bug

#### 1. Clone the Repo
- git clone https://github.com/CIBugs/Repo1.git

#### 2. Checkout a specific Bug
- git checkout <'bug id'>
  - e.g. : git checkout Bug1
- cd Repo1
  
#### 3. Get all commits for the bug and pick last 2 commits
- git log --pretty=format:"%h - %s"
  - 804fcb6a3 - Fixed from https://github.com/petergeneric/stdlib/commit/e423651b7c715465271a4da4482d2cf2a9b3c955
  - 4e628d461 - Buggy from https://github.com/petergeneric/stdlib/commit/b63a6a839e276ac66a45b4e114894fb20cd7fa00
  - 4daa8d962 - Initial commit

#### 4. Point to Fixed Commit
- git reset --hard <'commit id'>
  - e.g. : git reset --hard 804fcb6a3
  
#### 5. Point to Buggy Commit
- git reset --hard <'commit id'>  
  - e.g. : git reset --hard 4e628d461

## Bugs and Project Details
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




