# Spring Batch

이 레포지토리는 Spring Batch의 심층적인 이해와 효과적인 활용을 위한 학습 및 개발 프로젝트입니다. [EcoFarming](https://github.com/KimJ4ehyun/EcoFarming) 프로젝트에서 사용했던 Spring Batch 구현에만 집중했던 것이 아쉬워서, 이 기술의 핵심 가치와 장점을 최대한 활용하는 방향으로 발전시키는 것을 목표로 합니다.

## 목적
* Spring Batch의 아키텍처와 핵심 개념에 대한 깊이 있는 이해  
* 기존 프로젝트의 배치 처리 로직 개선 및 최적화

## 개발 방향
* 기존 EcoFarming 프로젝트의 핵심 배치 처리 로직을 기반으로 시작  
* 불필요한 요소들을 제거하고 Spring Batch의 장점을 극대화할 수 있는 구조로 재설계  
* 재시작/재실행 시나리오를 고려한 안정적인 Job 구성  

## 학습 목표
* 효율적인 배치 작업 모니터링 및 오류 처리 방안 구축
* 로깅 및 진행 상황 추적 시스템 구축
* ItemReader 구현체 비교 및 최적 선택(당시 프로젝트 기준)
* ItemWriter 구현체 비교 및 최적 선택(당시 프로젝트 기준)
* 재시도 메커니즘과 오류 처리 구현
* 테스트 가능한 배치 작업 설계 및 구현
* 가능하다면 성능 테스트까지

## 기술 스택
* Spring Boot
* Spring Batch

## 개념
* Batch
    * 일괄적으로 대량의 데이터를 처리하는 작업 방식

* Spring Batch
    * 배치 애플리케이션을 개발할 수 있도록 설계된 가볍고 포괄적인 배치 프레임워크
    * 로깅 및 추적, 트랜잭션 관리, 작업 처리 통계, 작업 재시작, 건너뛰기 및 리소스 관리를 포함하여 대량의 레코드를 처리하는 데 필수적인 재사용 가능한 기능을 제공

## 용어
* Job
    * 배치 처리 과정을 하나의 단위로 만들어 놓은 객체
    * 배치 처리 과정에서 전체 계층 최상단
* JobInstance
    * 모든 Job의 실행의 단위
    * 같은 파라미터로 실행된 동일한 배치 작업
* JobExecution
    * JobInstance 실행 시도에 대한 객체
    * JobInstance 실행에 대한 상태, 시작 시간, 종료 시간, 생성 시간 등의 정보를 가지고 있음
    * JobInstance가 실패해서 재실행하더라도 JobInstance는 하나지만 JobExecution은 여러 개
* JobParameters
    * JobInstance에 전달되는 매개변수
    * String, Long, Double, Date만 지원
    * JobInstance를 구별하는 역할도 함
* JobRepository
    * Job 실행 상태와 관련된 모든 정보를 저장하는 곳
* JobLauncher
    * Job을 실행하는 인터페이스, JobParameters를 받아 Job을 실행
* Step
    * Job의 배치 처리를 정의하고 순차적인 단계를 캡슐화
    * Job은 최소한 1개 이상의 Step을 가져야 하고, Job의 실제 일괄 처리를 제어하는 모든 정보가 들어있음
* StepExecution
    * Step 실행 시도에 대한 객체
    * 여러 단계의 Step으로 구성되어있을 때 이전 단계의 Step이 실패하면, 이후 StepExcution은 생성 x
    * Step 실행에 대한 상태, 시작 시간, 종료 시간, 생성 시간, read 수, write 수, commit 수 등의 정보도 저장
* ExecutionContext
    * Job에서 데이터를 공유할 수 있는 데이터 저장소
    * JobExecutionContext → 모든 Step에서 접근 가능, 실행 중 공유할 정보 저장
    * StepExecutionContext → 개별 Step에만 적용, Step 내에서 상태를 저장하여 이후에 동일한 Step을 재실행할 때도 사용
* ItemReader
    * 데이터를 읽어오는 역할
    * 파일, 데이터베이스, API 등 다양한 곳에서 데이터를 읽을 수 있음
    * FlatFileItemReader → 파일
    * JdbcCursorItemReader → 데이터베이스
    * StaxEventItemReader → XML 데이터
* ItemProcessor
    * ItemReader에서 읽어온 데이터를 처리하는 역할
* ItemWriter
    * ItemProcessor에서 처리된 데이터를 외부에 저장 또는 출력
    * FlatFileItemWriter → 파일
    * JdbcBatchItemWriter → 데이터베이스
    * StaxEventItemWriter → XML 데이터
* Tasklet
    * 단일 작업을 처리하는 단순한 형태의 배치 구성 요소
    * 전체 작업을 한 번만 하는 것에 적합



## 출처
* [Spring Batch란? 이해하고 사용하기](https://khj93.tistory.com/entry/Spring-Batch%EB%9E%80-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B3%A0-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)