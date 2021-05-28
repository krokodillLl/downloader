Загрузка excel файлов с сайта Федстат.

-Установка: собрать jar файл, запустив соответствующую задачу для gradle.
-перейти в директорию сгенерированного jar файла, открыть окно powerShell/cmd/bash и запустить его, передав следующий набор параметров:
*readPath - путь к файлу с параметрами для POST-запроса.
*writePath - путь к директории, в которую будут загружаться файлы.
*replaceYear - boolean значение (true/false), в зависимости от значения которого происходит подстановка текущего года во все запросы 
(Если в файле параметров лежит запрос для 2015 года - запрос будет аналогичен, но выбранный год будет равен текущему (2021)).

-Файл параметров формируется по следующему шаблону: 
*Строка - название параметра (по нему будет генерироваться название загружаемого файла).
*Строка - тело запроса, начиная с параметра id.
-Пример файла параметров:
test download data for 2020 (automatic date replacement)
id=31074&lineObjectIds=57937&lineObjectIds=58273&lineObjectIds=57831&lineObjectIds=30611&columnObjectIds=3&columnObjectIds=33560&selectedFilterIds=0_31074&selectedFilterIds=3_2020&selectedFilterIds=30611_950473&selectedFilterIds=33560_1540222&selectedFilterIds=33560_1540224&selectedFilterIds=33560_1540226&selectedFilterIds=33560_1540227&selectedFilterIds=33560_1540228&selectedFilterIds=33560_1540229&selectedFilterIds=33560_1540230&selectedFilterIds=33560_1540233&selectedFilterIds=33560_1540234&selectedFilterIds=33560_1540235&selectedFilterIds=33560_1540236&selectedFilterIds=33560_1540272&selectedFilterIds=33560_1540273&selectedFilterIds=33560_1540276&selectedFilterIds=33560_1540282&selectedFilterIds=33560_1540283&selectedFilterIds=57831_1688487&selectedFilterIds=57937_1707674&selectedFilterIds=58273_1707675&selectedFilterIds=58273_1709748&selectedFilterIds=58273_1744146&filterObjectIds=0

test download data for 2019 (automatic date replacement)
id=31074&lineObjectIds=57937&lineObjectIds=58273&lineObjectIds=57831&lineObjectIds=30611&columnObjectIds=3&columnObjectIds=33560&selectedFilterIds=0_31074&selectedFilterIds=3_2019&selectedFilterIds=30611_950473&selectedFilterIds=33560_1540222&selectedFilterIds=33560_1540224&selectedFilterIds=33560_1540226&selectedFilterIds=33560_1540227&selectedFilterIds=33560_1540228&selectedFilterIds=33560_1540229&selectedFilterIds=33560_1540230&selectedFilterIds=33560_1540233&selectedFilterIds=33560_1540234&selectedFilterIds=33560_1540235&selectedFilterIds=33560_1540236&selectedFilterIds=33560_1540272&selectedFilterIds=33560_1540273&selectedFilterIds=33560_1540276&selectedFilterIds=33560_1540282&selectedFilterIds=33560_1540283&selectedFilterIds=57831_1688487&selectedFilterIds=57937_1707674&selectedFilterIds=58273_1707675&selectedFilterIds=58273_1709748&selectedFilterIds=58273_1744146&filterObjectIds=0

test download data for 2015 (automatic date replacement)
id=31074&lineObjectIds=57937&lineObjectIds=58273&lineObjectIds=57831&lineObjectIds=30611&columnObjectIds=3&columnObjectIds=33560&selectedFilterIds=0_31074&selectedFilterIds=3_2015&selectedFilterIds=30611_950473&selectedFilterIds=33560_1540222&selectedFilterIds=33560_1540224&selectedFilterIds=33560_1540226&selectedFilterIds=33560_1540227&selectedFilterIds=33560_1540228&selectedFilterIds=33560_1540229&selectedFilterIds=33560_1540230&selectedFilterIds=33560_1540233&selectedFilterIds=33560_1540234&selectedFilterIds=33560_1540235&selectedFilterIds=33560_1540236&selectedFilterIds=33560_1540272&selectedFilterIds=33560_1540273&selectedFilterIds=33560_1540276&selectedFilterIds=33560_1540282&selectedFilterIds=33560_1540283&selectedFilterIds=57831_1688487&selectedFilterIds=57937_1707674&selectedFilterIds=58273_1707675&selectedFilterIds=58273_1709748&selectedFilterIds=58273_1744146&filterObjectIds=0

test download data for 2021 (automatic date replacement)
id=31074&lineObjectIds=57937&lineObjectIds=58273&lineObjectIds=57831&lineObjectIds=30611&columnObjectIds=3&columnObjectIds=33560&selectedFilterIds=0_31074&selectedFilterIds=3_2021&selectedFilterIds=30611_950473&selectedFilterIds=33560_1540222&selectedFilterIds=33560_1540224&selectedFilterIds=33560_1540226&selectedFilterIds=33560_1540227&selectedFilterIds=33560_1540228&selectedFilterIds=33560_1540229&selectedFilterIds=33560_1540230&selectedFilterIds=33560_1540233&selectedFilterIds=33560_1540234&selectedFilterIds=33560_1540235&selectedFilterIds=33560_1540236&selectedFilterIds=33560_1540272&selectedFilterIds=33560_1540273&selectedFilterIds=33560_1540276&selectedFilterIds=33560_1540282&selectedFilterIds=33560_1540283&selectedFilterIds=57831_1688487&selectedFilterIds=57937_1707674&selectedFilterIds=58273_1707675&selectedFilterIds=58273_1709748&selectedFilterIds=58273_1744146&filterObjectIds=0

-Для упрощения процесса запуска можно создать исполняемый файл (для windows - .bash). Пример файла:
java -jar downloader-2.jar C:\Users\user\Downloads\parameters.txt C:\Users\user\Downloads\ true

-При запуске такого файла запрос будет формироваться из файла C:\Users\user\Downloads\parameters.txt, а загруженные файлы будут сохраняться в C:\Users\user\Downloads\{имя параметра},
при этом год в запросе будет перезаписываться на текущий, так как передан параметр true.
