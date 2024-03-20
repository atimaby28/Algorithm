USE programmers_db;

CREATE TABLE REST_REVIEW  
(
	REVIEW_ID VARCHAR(10) NOT NULL,
    REST_ID VARCHAR(10) NOT NULL,
    MEMBER_ID VARCHAR(100),
	REVIEW_SCORE INTEGER,
    REVIEW_TEXT VARCHAR(100),
    REVIEW_DATE VARCHAR(20)
    
);


INSERT INTO REST_REVIEW VALUES('R000000001',	'00001',	'min09125@naver.com',	5,	'3시간 넘는 웨이팅이었지만 그래도 가볼만한 곳',	'2022-03-29 00:00:00'); 
INSERT INTO REST_REVIEW VALUES('R000000002',	'00004',	'ksjs1115@gmail.com',	5,	'끝도 없이 주셔서 배터졌음 그리고 등푸른생선류 넘 맛있음',	'2022-04-11 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000003',	'00004',	'jihoon93@hanmail.net',	4,	'하나도 안 맵고 조화로운 맛이 나서 놀랐다',	'2022-04-13 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000004',	'00018',	'ksjs1115@gmail.com',	3,	'우리가 흔히 생각하는 떡볶이랑은 맛이 사뭇 달라요',	'2022-04-16 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000005',	'00018',	'doooj219@gmail.com',	4,	'저의 단연 넘버원',	'2022-04-01 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000006',	'00013',	'yoonsy94@gmail.com',	4,	'야들야들 역시나 맛있음',	'2022-04-30 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000010',	'00024',	'soso94@naver.com',	4,	'순대국은 얼큰한 스타일로 나옴',	'2022-03-11 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000011',	'00001',	'doooj219@gmail.com',	5,	'고기도 맛있지만 껍데기가 진짜 별미',	'2022-01-12 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000012',	'00001',	'soso94@naver.com',	5,	'쫄깃하면서도 육즙이 팡 터지는 맛이 아주 좋았어요.',	'2022-01-14 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000013',	'00004',	'min09125@naver.com',	4,	'줄무늬전갱이가 정말 맛있다',	'2022-01-10 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000014',	'00018',	'sw900429@nate.com',	5,	'뭔가 소스 끝에서 나오는 깊은 맛!!',	'2022-01-30 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000015',	'00013',	'soso94@naver.com',	4,	'쟁반국수와 감자전도 추천',	'2022-03-22 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000016',	'00024',	'sw900429@nate.com',	5,	'결론부터 말하자면 하나하나 다 맛있었습니다',	'2022-04-12 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000021',	'00001',	'yelin92@gmail.com',	5,	'갈빗대에 붙어있는 살도 예쁘게 잘라주시는데, 그 부위가 꼬소하니 또 별미',	'2022-03-20 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000022',	'00004',	'woojune96@naver.com',	4,	'기름기가 끝내준다. 입에 넣자마자 샤륵..',	'2022-02-22 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000023',	'00013',	'yelin92@gmail.com',	4,	'명불허전!',	'2022-03-01 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000024',	'00013',	'woojune96@naver.com',	4,	'쏘맥과 함께 즐기기에 딱 좋았던 곳!',	'2022-03-07 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000025',	'00001',	'yoonsy94@gmail.com',	5,	'냉면은 무조건 주문하세요!',	'2022-03-07 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000026',	'00004',	'jimin88@naver.com',	5,	'여태 먹은 붕장어 스시중 가장 맛있었다',	'2022-03-01 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000030',	'00001',	'seoyeons@naver.com',	5,	'살코기가 으스러질 정도로 부드러웠습니다.',	'2022-04-25 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000031',	'00001',	'yeahjin98@nate.com',	5,	'친구들은 처음이었는데 다들 너무너무 맛있다며 감탄 감탄을',	'2022-04-13 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000039',	'00001',	'yeseo92@naver.com',	5,	'삼겹살 녹습니다.',	'2022-05-11 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000040',	'00002',	'ksjs1115@gmail.com',	5,	'바삭바삭해요',	'2022-05-23 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000041',	'00003',	'yeseo92@naver.com',	4,	'파스타 꼭 드셔보세요',	'2022-05-22 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000042',	'00003',	'seoyeons@naver.com',	4,	'먹물 파스타 일품입니다.',	'2022-04-20 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000043',	'00002',	'jihoo95@nate.com',	4,	'카레도 추가해서 드셔보세요',	'2022-04-24 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000044',	'00001',	'minjea985@naver.com',	5,	'삼겹보다 목살이 더 두껍게 잘라주시는데 씹을 때마다 육즙이 ㅜㅜ 환상',	'2022-03-15 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000045',	'00004',	'minjea985@naver.com',	4,	'사람들이 왜 이 음식점을 찬양하는지 알것도 같다',	'2022-02-21 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000046',	'00004',	'jihoo95@nate.com',	4,	'어마어마한 곳이다. 의심의 여지가 없다',	'2022-02-19 00:00:00');
INSERT INTO REST_REVIEW VALUES('R000000047',	'00024',	'minjea985@naver.com',	5,	'안에 찰밥이 들어있는건지 속 내용물이 특히 맛있었어요',	'2022-02-18 00:00:00');