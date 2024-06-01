<template>
  <div>
    <!-- 자식의 name을 searchName으로 전달하고 다시 자식의 변경 값을 받아옴 -->
    <inputName v-model:name="searchName"></inputName>
    <!-- 위의 코드로 쓰면 생략 가능 -->
    <!-- <InputName :name="searchName" @update:name="ChangeSearchName"></InputName> -->
    <h3>검색어 : {{ searchName }}</h3>
  </div>
</template>

<script>
import inputName from './components/inputName.vue';

export default {
  name: 'App',
  components: { inputName },

  data() {
    return {
      searchName: 'John',
    };
  },
  methods: {
    // v-model로 양방향 바인딩 시 생략 가능
    changeSearchName(name) {
      console.log(name);
      this.SearchName = name;
    },
  },
};
</script>

<style>
.header {
  padding: 20px 0px 0px 20px;
}

.headerText {
  padding: 0px 20px 40px 20px;
}
.tab {
  padding: 30px;
}
</style>
