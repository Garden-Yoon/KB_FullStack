<template>
  <div>
    <h3>당신이 경험한 프론트엔드 기술은 ? (두번째 : Slot 기본 )</h3>
    <!-- items 배열을 순회하면서 자식의 props에 해당하는 값들을 넘겨준다 -->
    <!-- 자식에서 보낸 check-changed 이벤트에 CheckBoxChanged 함수 연결 -->
    <!-- checkbox1 태그 사이에 자식에게 넘겨주고싶은 값 추가 -->
    <CheckBox2
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    >
      <template v-slot:icon>
        <!-- 체크박스의 체크여부에 따라 다른 아이콘 출력 -->
        <i v-if="item.checked" class="far fa-grin-beam"></i>
        <i v-else class="far fa-frown"></i>
      </template>
      <template v-slot:label>
        <!-- 체크박스의 체크여부에 따라 다른 스타일 출력 -->
        <span
          v-if="item.checked"
          style="color: blue; text-decoration: underline"
          ><i>{{ item.label }}</i></span
        >
        <span v-else style="color: gray">{{ item.label }}</span>
      </template>
    </CheckBox2>
  </div>
</template>

<script>
import CheckBox2 from './CheckBox2.vue';
export default {
  name: 'NamedSlotTest',
  components: { CheckBox2 },
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

<style>
/* fontawesome 적용 */
@import url(https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css);
</style>
