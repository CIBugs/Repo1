# CI-Bugs 

This is a collection of 102 regression bugs from the real time build pipe line (Travis) from 40 diverse projects. At first sight this might look as only a read me page but it has the complete dataset within the branches of this repo. Please read the below instructions carefully to setup the bugs.

## Setup

The bugs are setup in the branches of this repo. Each bug is setup in a seperate branch.

Each branch as 3 commits.
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
  
#### 3. Get all commits for the bug and pick 2 commits (Fixed and Buggy)
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



## Bugs and Lines Modified 
Bug ID|File Changes|Line Changes|
| ------------- | ------------- |-------------  |
|1|1|1|
|2|1|1|
|3|1|1||
|4|5|9||
|5|2|3|
|6|2|2|
|7|1|2|
|8|2|2|
|9|2|33|
|10|7|44|
|11|1|5|
|12|1|1|
|13|1|1|
|14|2|6|
|15|1|1|
|16|1|1|
|17|1|1|
|18|1|1|
|19|1|11|
|20|1|1|
|21|4|12|
|22|1|1|
|23|1|1|
|24|5|65|
|25|3|65|
|26|4|16|
|27|2|9|
|28|1|2|
|29|1|5|
|30|1|2|
|31|1|1|
|32|1|1|
|33|1|2|
|34|2|2|
|35|1|2|
|36|5|23|
|37|5|23|
|38|2|12|
|39|1|3|
|40|7|43|
|41|1|1|
|42|1|3|
|43|1|1|
|44|1|1|
|45|1|2|
|46|1|1|
|47|1|1|
|48|1|1|
|49|1|6|
|50|1|1|
|51|1|1|
|52|1|2|
|53|1|1|
|54|1|4|
|55|1|2|
|56|1|3|
|57|1|1|
|58|1|2|
|59|1|1|
|60|1|1|
|61|2|5|
|62|1|6|
|63|1|5|
|64|1|3|
|65|2|5|
|66|1|1|
|67|1|3|
|68|1|2|
|69|1|5|
|70|1|4|
|71|1|1|
|72|1|1|
|73|1|1|
|74|1|1|
|75|1|3|
|76|1|1|
|77|1|1|
|78|1|2|
|79|1|1|
|80|1|1|
|81|1|2|
|82|1|1|
|83|1|1|
|84|1|3|
|85|1|1|
|86|1|5|
|87|1|2|
|88|1|2|
|89|1|1|
|90|1|1|
|91|1|2|
|92|1|3|
|93|2|3|
|94|1|4|
|95|1|1|
|96|1|1|
|97|1|1|
|98|1|1|
|99|1|1|
|100|1|1|
|101|1|3|
|102|1|1|
|103|1|2|
|104|1|1|
|105|1|2|
|106|1|4|
|107|2|4|
