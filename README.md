# TWAGO Technical Test

The following executable was done by Julian Ontanaya Rincon for Backend Developer Job interview. The requirements were specified according to the PDF sent for the technical test

## Installation

You would need Java 11 installed. No Further installation is required for the execution of this jar.


## Usage

There are two ways to execute the jar file. The user can specify a path to a file with the format specied on the requirements of the test on this way

```bash
java -jar TwagoTest.jar C:\path\to\your\file\your_file.txt
```

There is also one posibility to execute the program if the numeric sequence is specified (with no new lines characters) as program arguments. For example:
```bash
java -jar TwagoTest.jar 5 3 1 2 100 2 5 100 3 4 100
```
Following this launch option the program will assume that the numeric sequence will have the following format according to the specified requirements.
```bash
5(x) 3(y) 1(i0) 2(j0) 100(k0) 2(i1) 5(j1) 100(k1) 3(i2) 4(j2) 100(k2)
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

You can find the code on my public github profile:

[Julian Ontanaya Rincon - Twago Test GitHub Link](https://github.com/julijulito/TwagoTest)