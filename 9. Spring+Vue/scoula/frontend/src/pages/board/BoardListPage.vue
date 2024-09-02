<script setup>
import api from '@/api/boardApi';
import { ref, reactive, computed } from 'vue';
import moment from 'moment';
import { useRoute, useRouter } from 'vue-router';

const cr = useRoute();
const router = useRouter();

const page = ref({});

// page.value가 바뀌는 동시에 다시 계산된다
const articles = computed(() => page.value);
const load = async () => {
  try {
    // API 호출을 통해서 게시판 목록을 가져와서 저장한다
    page.value = await api.getList();
    console.log(page.value);
  } catch {}
};
load();
</script>

<template>
  <div>
    <h1 class="mb-3"><i class="fa-solid fa-paste"></i> 게시글 목록</h1>
    <table class="table table-striped">
      <thead>
        <tr>
          <th style="width: 60px">No</th>
          <th>제목</th>
          <th style="width: 100px">작성자</th>
          <th style="width: 120px">작성일</th>
        </tr>
      </thead>
      <tbody>
        <!-- article은 BoardDTO를 의미한다 -->
        <tr v-for="article in articles" :key="article.no">
          <td>{{ article.no }}</td>
          <td>
            <!-- board/detail, 상세보기 페이지로 이동하면서 파라미터로 게시글의 번호를 넘겨준다 -->
            <router-link :to="{ name: 'board/detail', params: { no: article.no } }">
              {{ article.title }}
            </router-link>
          </td>
          <td>{{ article.writer }}</td>
          <td>{{ moment(article.regDate).format('YYYY-MM-DD') }}</td>
        </tr>
      </tbody>
    </table>
    <div class="my-5 d-flex">
      <div class="flex-grow-1 text-center">페이지 네이션</div>
      <div>
        <!-- 글 작성 페이지로 이동하는 버튼 -->
        <router-link :to="{ name: 'board/create' }" class="btn btn-primary"> <i class="fa-solid fa-pen-to-square"></i> 글 작성</router-link>
      </div>
    </div>
  </div>
</template>
