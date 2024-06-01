<template>
  <div>
    X: <input type="text" v-model.number="state.x" /> <br />
    <div>결과 : {{ state.result }}</div>

    <br />
  </div>
</template>

<script>
// composition API 내의 함수를 사용하려면 import 필수
import { reactive, watch } from 'vue';

export default {
  name: 'Calc6',
  setup() {
    const state = reactive({ x: 0, result: 0 });
    const result = ref(0);
    watch(
      // 첫번째 인자로는 반응성 데이터가 와야하기 때문에 state.x는 불가능
      // 화살표 함수로 객체 내의 데이터를 접근해야 한다
      // 객체 안쪽에 접근하려면 화살표 함수로 전달
      () => state.x,
      (current, old) => {
        console.log(`${old}->${current}`);
        state.result = current * 2;
      }
    );
    return { state };
  },
};
</script>
