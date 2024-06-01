<template>
  <div>
    <h3>당신이 경험한 프론트엔드 기술은 ? (en번째 : Slot 기본 )</h3>
    <!-- items 배열을 순회하면서 자식의 props에 해당하는 값들을 넘겨준다 -->
    <!-- 자식에서 보낸 check-changed 이벤트에 CheckBoxChanged 함수 연결 -->
    <!-- checkbox1 태그 사이에 자식에게 넘겨주고싶은 값 추가 -->
    <CheckBox1
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    >
      <!-- slot으로 보내줄 요소는 무조건 자식 컴포넌트 태그 사이에 위치한다 -->
      <!-- 기존코드는 props에서 checked와 label을 가져왔으므로 부모에서는 item 내로 접근해줘야한다 -->
      <span v-if="item.checked" style="color: blue; text-decoration: underline"
        ><i>{{ item.label }}</i></span
      >

      <!-- 체크 해제되었을 경우 렌더링되는 span -->
      <span v-else style="color: gray">{{ item.label }}</span>
    </CheckBox1>
  </div>
</template>

<script>
import CheckBox1 from './CheckBox1.vue';
export default {
  name: 'SlotTest',
  components: { CheckBox1 },
  data() {
    return {
      items: [
        { id: 'v', checked: true, label: 'Vue' },
        { id: 'a', checked: false, label: 'Angular' },
        { id: 'r', checked: false, label: 'React' },
        { id: 's', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    CheckBoxChanged(e) {
      // 변경된 체크박스의 id로 현재 items 배열에서 해당 요소를 찾는다
      let item = this.items.find((item) => item.id === e.id);
      item.checked = e.checked;
    },
  },
};
</script>
