# VSCode로 스프링부트 연습

VSCode로 시작하는 스프링부트

## 실행

1. 깃 클론
```bash
git clone https://github.com/HaHoLuLa/SpringBoot
```

2. env 파일 생성
```env
DB_URL=<데이터베이스_URL>
DB_USER=<데이터베이스_유저>
DB_PASSWORD=<데이터베이스_비밀번호>

FRONT_URL=<프론트엔드_URL>
```

## 도커 이미지

1. 프로젝트 빌드
```bash
./gradlew clean build
```

2. 도커 이미지 빌드
```bash
docker build -t <이미지명> .
```

3. 도커 컨테이너 실행
```bash
docker run -p 8080:8080 --name <컨테이너명> -it -e DB_URL=<데이터베이스_URL> -e DB_USER=<데이터베이스_유저> -e DB_PASSWORD=<데이터베이스_비밀번호> -e <프론트엔드_URL> <이미지명>
```