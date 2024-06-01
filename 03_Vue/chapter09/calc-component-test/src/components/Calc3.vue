<template>
  <div>
    X: <input type="text" v-model.number="state.x" /> <br />
    Y: <input type="text" v-model.number="state.y" /> <br />
    <button>계산</button>
    <div>결과 : {{ state.result }}</div>

    <br />
  </div>
</template>

<script>
// composition API 내의 함수를 사용하려면 import 필수
import { reactive } from 'vue';

export default {
  name: 'Calc3',
  setup() {
    // reactive로 참조형 데이터를 감싸줘야 반응형으로 동작한다
    // 기존 옵션 API의 data와 같은 역할
    const state = reactive({ x: 10, y: 20, result: 30 });
    //참조형 데이터는 .value로 접근할 필요가 없다
    const calcAdd = () => {
      state.result = state.x + state.y;
    };
    return { state, calcAdd };
  },
};
</script>
