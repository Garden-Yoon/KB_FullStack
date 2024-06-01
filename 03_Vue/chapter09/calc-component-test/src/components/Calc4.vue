<template>
  <div>
    X: <input type="text" v-model.number="state.x" /> <br />
    Y: <input type="text" v-model.number="state.y" /> <br />
    <div>결과 : {{ result }}</div>

    <br />
  </div>
</template>

<script>
// composition API 내의 함수를 사용하려면 import 필수
import { reactive, computed } from 'vue';

export default {
  name: 'Calc4',
  setup() {
    // computed로 계산해주기때문에 result 초기화 필요 없어짐
    const state = reactive({ x: 10, y: 20 });
    const result = computed(() => {
      return state.x + state.y;
    });
    return { state, result };
  },
};
</script>
