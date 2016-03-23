 #!/bin/sh

./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=buttonShouldUpdateText
./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=buttonShouldUpdateTextNope
